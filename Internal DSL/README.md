Run with

Linux:
```cmd
    cd <Internal DSL Syntax Path>
    mkdir -p build
    javac -d build $(find src -name "*.java")
    java -cp build Example.Main
```

Wiondows:
```pw
    cd <Internal DSL Syntax Path>
    mkdir build
    javac -d build (Get-ChildItem -Recurse src -Filter *.java | % { $_.FullName })
    java -cp build Example.Main
```