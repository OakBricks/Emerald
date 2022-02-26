# Contributing to the OakLauncher API

## Commit notes
Every commit note related to the API ***must*** be prefixed with `(API)` 
alongside other commit prefixes (Check CONTRIBUTING.md for more info)

### Example:
```(API) [NI] Reticulate Splines```

## Code format
Code must
- be valid for java 17
- be stable and mostly reliable
- be readable
- and adhere to [java conventions](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
- useless unused methods, fields, and classes must provide some function that could be used by another project, if not used by OakLauncher

Good code formatting:
```java
package org.oakbricks.launcherapi;

public class HelloWorld {
    // Spaces before comments
    public static void main() {
        // No line escapes after a method name
        Logger.info("Hello World");
        // Make sure to use a Logger for long-term logging, System.out is allowed for temporary debugging
    }
    
    // Names adhere to java standards
    public int exampleInt() {
        // I prefer if variable and field names are more than one character,
        // but this is fine.
        int i = 0;
        return i++;
    }
}
```

Bad code formatting:
```java
// Holy fuck, please don't introduce grammatically correct packages
package Org.OakBricks.LauncherAPI;

// For the love of god don't do this C-style, why is this even valid java
public class helloworld
{
    // There is so much wrong with this, how can I even begin
public void Main(int _a /*important number*/, example_class b)
    {
        while (true) {
            _a++;
            System.out.println(_a);
        }
}
    
    // Methods cannot be public if they are not user-facing!
    // Also names MUST follow java naming conventions!
    public static void InternalMethod(int i, String s) {
        i = s.hashCode();
        System.out.println("Set i to {}", i);
    }
}
```