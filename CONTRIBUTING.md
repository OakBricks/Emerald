# Contributing to OakLauncher

## Commit notes
Every commit (or pull request) must be prefixed with the following

| Prefix | Usage                                                                                                                                        |
|--------|----------------------------------------------------------------------------------------------------------------------------------------------|
| NI     | Not an issue, such as future proofing and other small additions that have no effect on functionality                                         |
| ADD    | Large additions, such as adding modpack support                                                                                              |
| RBF    | Bugfix for a reported bug, Fixes a bug (commit note must be suffixed by issue number (Example `[RBF] Fix splines not reticulating (#1, #3)`) |
| BF     | Bugfix for an unreported bug, Fixes a bug not mentioned on any issue tracker, official or unofficial                                         |
| QOL    | Quality of life improvement, such as adding a new settings option that improves usability.                                                   |


## Code format
Code must
- be valid in java 17 (compatibility with earlier java versions is better, but not required)
- be somewhat stable and mostly reliable (no huge bugs)
- be mostly readable
- adhere to most or all of the [java conventions](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
- have all functions, fields, variables, etc have a use outside or inside of OakLauncher and related projects

## Code formatting

Good code formatting:

```java
package org.oakbricks.emerald;

// Any words in class names must be capitalized
public class HelloWorld {
    // Spaces before comments
    public static void main() {
        // No line escapes after a method name
        Logger.info("Hello World");
        // Make sure to use a Logger for any kind of logging that is meant to be shown in a stable release, or even a snapshot (any build from CI), but System.out is allowed for temporary debugging
    }

    // Names adhere to java standards
    public int exampleInt() {
        // I prefer if any variable names are more than one character,
        // but this is fine.
        int i = 0;
        return i++;
    }
}
```

Bad code formatting:
```java
// Holy fuck, please don't introduce grammatically correct packages, and don't mention GUI in the package where the Main class is (org.oakbricks.emerald)
package Org.OakBricks.LauncherGUI;

// For the love of god don't do this C-style, why is this even valid java
public class helloworld
{
    // There is so much wrong with this, how can I even begin
public void Main(int _a /*important number*/, example_class b)
    {
        while (i >= 15) {
            _a++;
            System.out.println(_a);
        }
}
    
    // Methods cannot be public if they are not used for basic utilities used by most classes!
    // Also names MUST follow java naming conventions!
    public static void InternalMethod(int i, String s) {
        i = s.hashCode();
        System.out.println("Set i to {}", i);
    }
}
```