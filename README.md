# CPOO Workspace

Workpace used to contain all tools and projects for the [*CPOO part of
TCS3-IN*](https://lms.isae.fr/course/view.php?id=3169), in particular Java
development with the VS Code editor.

## Software requirements

- Bash
- Java 11
- VS Code
- Java plugins for VS Code

You can find [*installation instructions on the
LMS*](https://lms.isae.fr/course/view.php?id=3169#section-1).

## Opening or creating Java projects in the terminal

1. Open a terminal
2. Go to the workspace directory with the `cd` command
3. Type the following command in the terminal and follow the instructions

```bash
    ./cpoo help
```

### Example #1: opening a project already present in the workspace

During lab *M1*, you will open the existing `M1` project in its own VS Code
window by typing:

```bash
    code M1
```

or:

```bash
    ./cpoo open M1
```

This will open a new VS Code window for the `M1` project, where you can edit
Java code and safely run or test it, according to the LMS activities. Compared
to `code`, `./cpoo open` will also open any existing Java file, thus quickly
activating the VS Code Java mode.

### Example #2: creating a new Java project

If needed, open a terminal and `cd` to the workspace folder. Then just type:

```bash
    ./cpoo create MyShinyProject
    ./cpoo open MyShinyProject
```

This will create the `MyShinyProject` Java project in the workspace, and open a
new VS Code window for it.

## Archiving your work

You can archive your individual projects or the whole workspace as `tgz` archive
files, that you can then move around wherever you need.

These `tgz` archives can then be listed or extracted with the `tar` command
available in Bash:

- `tar tzf file.tgz` will list the content of the archive
- `tar xzf file.tgz` will extract the archive content in the current folder

Note that the `cpoo` tool does **not** allow to create `zip` archives.

### Example #3: exporting a Java project as a `tgz` archive

If needed, open a terminal and `cd` to the workspace folder. Then just type:

```bash
    ./cpoo export M1
```

This will create an `M1.tgz` archive file in the workspace. As stated above:

- `tar tzf M1.tgz` will list the content of the archive
- `tar xzf M1.tgz` will extract the archive content in the current folder

### Example #4: entirely exporting your workspace as a `tgz` archive

If needed, open a terminal and `cd` to the workspace folder. Then just type:

```bash
    ./cpoo dump
```

This will create an `workspace.tgz` archive file in the parent directory of your
workspace (`..`).  As stated above:

- `tar tzf ../workspace.tgz` will list the content of the archive
- `tar xzf ../workspace.tgz` will extract the archive content in the current
  folder
