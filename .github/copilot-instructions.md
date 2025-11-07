## Repo-specific instructions for AI coding assistants

This repository is a small collection of standalone Java practice programs (algorithm / interview-style). The guidance below focuses on repository conventions, run/build commands, and concrete examples so an AI agent can be productive immediately.

Key facts
- All source files are top-level Java files in the repository root (no packages). Example files: `MagicSquare.java`, `JumpGame.java`, `LongestSusbstringWithoutRepeating.java`, `DuplicateElement.java`.
- Each file contains a single public class with a `public static void main(String[] args)` where present. Treat each file as an independent program rather than part of a multi-package Java project.
- There is no build system (Maven/Gradle) or src/ layout. Compilation and run use the JDK directly with `javac`/`java`.

How to compile and run (examples)
- Compile a single file:
  - `javac MagicSquare.java`
  - `java MagicSquare`
- Compile all Java files in the folder:
  - `javac *.java`  (produces .class files in repo root)
  - `java <ClassName>` to run a specific program (e.g. `java JumpGame`).

Coding patterns and conventions to follow when editing or adding files
- Keep each algorithm/self-contained example in its own file and class. The repository expects single-file entrypoints with `main`.
- Avoid adding package declarations. These will complicate the simple `javac *.java` workflow.
- Use standard JDK collections (`java.util.*`) and primitive arrays; existing files use `ArrayList`, `HashSet`, and `Collections`.
- Naming: Files and class names match exactly (case-sensitive). Preserve this when creating new examples.

Common pitfalls seen in the codebase (what to watch for)
- Indexing errors: many examples work with arrays and indices — check off-by-one bounds (e.g., loops over length or length-1).
- Consistent main signatures: some helper classes may not provide `main`; only public classes with `main` are runnable.
- Sorted vs unsorted assumptions: `DuplicateElement.java` sorts input before searching; preserve intent if refactoring.

When adding tests or CI
- If you add a test harness, prefer small JUnit tests that compile each target class independently. Keep tests in a new `test/` or `tests/` directory and add a small README with the required `javac` and `java` commands — do not introduce Maven/Gradle silently.

Examples from this repo (use these as templates)
- `MagicSquare.java` — calculates expected magic sum from first row, verifies rows/columns and both diagonals. Use this when adding matrix utilities.
- `LongestSusbstringWithoutRepeating.java` — implements sliding-window with `HashSet` and two indices; good template for string-window problems.
- `JumpGame.java` — greedy max-reach approach; simple array-processing example.

When you modify files
- Re-compile changed files before committing. Commit compiled classes are not necessary, but ensure code compiles: `javac *.java`.
- If you rename a class/file, update the filename to match the public class name exactly.

What the AI assistant should NOT do
- Do not add package statements or a complicated build system automatically.
- Do not assume external dependencies; everything should compile with the standard JDK.

If unsure, ask the user to clarify
- If a change would introduce packages, new dependencies, or a build system, ask before proceeding.

Feedback request
- After applying changes or adding new examples, ask the user for preferred conventions for testing and whether they want a build system (Maven/Gradle) introduced.
