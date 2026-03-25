Run with

Linux:
```cmd
    cd <Internal DSL Syntax Path>
    mkdir -p build
    javac -d build $(find src -name "*.java")
    java -cp build <java build filename>
```

Wiondows:
```pw
    mkdir build
    cd <Internal DSL Syntax Path>
    javac -d build (Get-ChildItem -Recurse src -Filter *.java | % { $_.FullName })
    java -cp build <java build filename>
```