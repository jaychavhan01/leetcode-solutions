import os
import re
import shutil
import subprocess
import tempfile
import time
from pathlib import Path

import requests


# ============================================================
# CONFIGURATION
# ============================================================

REPO_DIR = Path(r"D:\leetcode-solutions")
COOKIE = os.environ.get("LEETCODE_COOKIE")

EXPORT_DIR = Path(tempfile.gettempdir()) / "leetcode_auto_export"

API_URL = "https://leetcode.com/graphql/"

HEADERS = {
    "User-Agent": "Mozilla/5.0"
}


# ============================================================
# TOPIC PRIORITY
# ============================================================

TOPIC_PRIORITY = [
    ("LinkedList", ["linked-list"]),
    ("BinarySearch", ["binary-search"]),
    ("SlidingWindow", ["sliding-window"]),
    ("TwoPointers", ["two-pointers"]),
    ("Backtracking", ["backtracking"]),
    ("DynamicProgramming", ["dynamic-programming"]),
    ("Greedy", ["greedy"]),
    ("Stack", ["stack", "monotonic-stack"]),
    ("Queue", ["queue"]),
    ("Heap", ["heap", "priority-queue"]),
    ("Trees", ["tree", "binary-tree", "binary-search-tree"]),
    ("Graphs", ["graph", "graph-theory"]),
    ("HashTable", ["hash-table"]),
    ("Sorting", ["sorting"]),
    ("Recursion", ["recursion"]),
    ("Math", ["math", "number-theory"]),
    ("BitManipulation", ["bit-manipulation"]),
    ("Trie", ["trie"]),
    ("Arrays", ["array"]),
    ("Strings", ["string"]),
]


# ============================================================
# CHECK COOKIE
# ============================================================

if not COOKIE:
    print("ERROR: LEETCODE_COOKIE environment variable not found.")
    print()
    print("Set it first in PowerShell:")
    print('$cookie = Get-Clipboard')
    print('[Environment]::SetEnvironmentVariable("LEETCODE_COOKIE", $cookie, "User")')
    print()
    exit(1)


# ============================================================
# LEETCODE API
# ============================================================

session = requests.Session()
session.headers.update(HEADERS)


def get_problem_info(slug):

    query = """
    query getQuestion($titleSlug: String!) {
        question(titleSlug: $titleSlug) {
            questionFrontendId
            title
            titleSlug
            difficulty
            topicTags {
                name
                slug
            }
        }
    }
    """

    payload = {
        "query": query,
        "variables": {
            "titleSlug": slug
        }
    }

    try:

        response = session.post(
            API_URL,
            json=payload,
            timeout=20
        )

        if response.status_code != 200:
            print(
                f"API error for {slug}: "
                f"{response.status_code}"
            )
            return None

        data = response.json()

        return data.get("data", {}).get("question")

    except Exception as e:

        print(
            f"Error getting information for {slug}: {e}"
        )

        return None


# ============================================================
# DETERMINE TOPIC
# ============================================================

def determine_topic(tags):

    tag_slugs = {
        tag["slug"].lower()
        for tag in tags
    }

    for topic, possible_tags in TOPIC_PRIORITY:

        for tag in possible_tags:

            if tag.lower() in tag_slugs:
                return topic

    return "Other"


# ============================================================
# GET EXISTING PROBLEM NUMBERS
# ============================================================

def get_existing_problem_numbers():

    numbers = set()

    for java_file in REPO_DIR.rglob("*.java"):

        match = re.match(
            r"^(\d+)-",
            java_file.name
        )

        if match:
            numbers.add(
                int(match.group(1))
            )

    return numbers


# ============================================================
# EXPORT LATEST ACCEPTED JAVA SUBMISSIONS
# ============================================================

def export_solutions():

    if EXPORT_DIR.exists():

        shutil.rmtree(
            EXPORT_DIR
        )

    EXPORT_DIR.mkdir(
        parents=True,
        exist_ok=True
    )

    print()
    print("=" * 60)
    print("Exporting accepted Java submissions...")
    print("=" * 60)

    command = [
        "python",
        "-m",
        "leetcode_export",

        "--cookies",
        COOKIE,

        "--folder",
        str(EXPORT_DIR),

        "--only-accepted",
        "--only-last-submission",

        "--language",
        "java",
    ]

    result = subprocess.run(
        command,
        cwd=str(REPO_DIR)
    )

    if result.returncode != 0:

        print()
        print("ERROR: LeetCode export failed.")
        exit(1)


# ============================================================
# FIND EXPORTED PROBLEMS
# ============================================================

def get_exported_problems():

    problems = []

    for folder in EXPORT_DIR.iterdir():

        if not folder.is_dir():
            continue

        match = re.match(
            r"^(\d+)-(.+)$",
            folder.name
        )

        if not match:
            continue

        number = int(
            match.group(1)
        )

        slug = match.group(2)

        java_files = list(
            folder.glob("*.java")
        )

        if not java_files:
            continue

        problems.append(
            {
                "number": number,
                "slug": slug,
                "folder": folder,
                "java_file": java_files[0]
            }
        )

    return problems


# ============================================================
# CLEAN TITLE
# ============================================================

def clean_filename(number, title):

    title = re.sub(
        r'[<>:"/\\|?*]',
        "",
        title
    )

    title = title.replace(
        " ",
        "-"
    )

    return f"{number}-{title}.java"


# ============================================================
# UPDATE README
# ============================================================

def update_readme(difficulty):

    readme_path = REPO_DIR / "README.md"

    content = readme_path.read_text(
        encoding="utf-8"
    )

    # Extract current values
    easy_match = re.search(
        r"\|\s*Easy\s*\|\s*(\d+)\s*\|",
        content
    )

    medium_match = re.search(
        r"\|\s*Medium\s*\|\s*(\d+)\s*\|",
        content
    )

    hard_match = re.search(
        r"\|\s*Hard\s*\|\s*(\d+)\s*\|",
        content
    )

    total_match = re.search(
        r"\|\s*Total\s*\|\s*(\d+)\s*\|",
        content
    )

    if not all([
        easy_match,
        medium_match,
        hard_match,
        total_match
    ]):

        print(
            "ERROR: Could not find Progress table in README."
        )

        return False

    easy = int(easy_match.group(1))
    medium = int(medium_match.group(1))
    hard = int(hard_match.group(1))
    total = int(total_match.group(1))

    if difficulty == "Easy":
        easy += 1

    elif difficulty == "Medium":
        medium += 1

    elif difficulty == "Hard":
        hard += 1

    total += 1

    content = re.sub(
        r"(\|\s*Easy\s*\|\s*)\d+(\s*\|)",
        rf"\g<1>{easy}\g<2>",
        content
    )

    content = re.sub(
        r"(\|\s*Medium\s*\|\s*)\d+(\s*\|)",
        rf"\g<1>{medium}\g<2>",
        content
    )

    content = re.sub(
        r"(\|\s*Hard\s*\|\s*)\d+(\s*\|)",
        rf"\g<1>{hard}\g<2>",
        content
    )

    content = re.sub(
        r"(\|\s*Total\s*\|\s*)\d+(\s*\|)",
        rf"\g<1>{total}\g<2>",
        content
    )

    readme_path.write_text(
        content,
        encoding="utf-8"
    )

    print()
    print("README updated:")
    print(f"Easy   : {easy}")
    print(f"Medium : {medium}")
    print(f"Hard   : {hard}")
    print(f"Total  : {total}")

    return True


# ============================================================
# PROCESS NEW SOLUTIONS
# ============================================================

def process_new_solutions():

    existing_numbers = (
        get_existing_problem_numbers()
    )

    exported = (
        get_exported_problems()
    )

    print()
    print(
        f"Existing Java problems : "
        f"{len(existing_numbers)}"
    )

    print(
        f"Exported Java problems : "
        f"{len(exported)}"
    )

    new_problems = [
        problem
        for problem in exported
        if problem["number"] not in existing_numbers
    ]

    if not new_problems:

        print()
        print("=" * 60)
        print("No new Java LeetCode problems found.")
        print("=" * 60)

        return False

    print()
    print(
        f"NEW PROBLEMS FOUND: "
        f"{len(new_problems)}"
    )

    changes_made = False

    for problem in new_problems:

        number = problem["number"]
        slug = problem["slug"]

        print()
        print(
            f"Processing {number}-{slug}"
        )

        info = get_problem_info(
            slug
        )

        if not info:

            print(
                "Could not retrieve LeetCode information."
            )

            continue

        title = info["title"]
        difficulty = info["difficulty"]
        tags = info.get(
            "topicTags",
            []
        )

        topic = determine_topic(
            tags
        )

        topic_dir = (
            REPO_DIR / topic
        )

        topic_dir.mkdir(
            exist_ok=True
        )

        filename = clean_filename(
            number,
            title
        )

        destination = (
            topic_dir / filename
        )

        shutil.copy2(
            problem["java_file"],
            destination
        )

        print(
            f"Title      : {title}"
        )

        print(
            f"Difficulty : {difficulty}"
        )

        print(
            f"Topic      : {topic}"
        )

        print(
            f"Saved      : {destination}"
        )

        update_readme(
            difficulty
        )

        changes_made = True

        time.sleep(0.5)

    return changes_made


# ============================================================
# GIT
# ============================================================

def git_command(args):

    return subprocess.run(
        ["git"] + args,
        cwd=str(REPO_DIR)
    )


def git_push():

    print()
    print("=" * 60)
    print("Git status")
    print("=" * 60)

    git_command(
        ["status"]
    )

    print()
    print("=" * 60)
    print("Adding changes...")
    print("=" * 60)

    result = git_command(
        ["add", "."]
    )

    if result.returncode != 0:
        return False

    print()
    print("=" * 60)
    print("Creating commit...")
    print("=" * 60)

    result = git_command(
        [
            "commit",
            "-m",
            "Add new LeetCode solution"
        ]
    )

    if result.returncode != 0:
        return False

    print()
    print("=" * 60)
    print("Pushing to GitHub...")
    print("=" * 60)

    result = git_command(
        [
            "push",
            "origin",
            "main"
        ]
    )

    return result.returncode == 0


# ============================================================
# MAIN
# ============================================================

def main():

    print()
    print("=" * 60)
    print("        LEETCODE → GITHUB AUTO SYNC")
    print("=" * 60)

    export_solutions()

    changes = process_new_solutions()

    if not changes:

        print()
        print("Nothing to push.")
        return

    success = git_push()

    print()

    if success:

        print("=" * 60)
        print("SUCCESS!")
        print("=" * 60)
        print(
            "New LeetCode solution(s) "
            "are now on GitHub."
        )

    else:

        print("=" * 60)
        print("Git push failed.")
        print("=" * 60)
        print(
            "Your solution and README changes "
            "are still saved locally."
        )


if __name__ == "__main__":
    main()