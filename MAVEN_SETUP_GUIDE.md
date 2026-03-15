# Maven Setup - Quick Fix Guide

## ✅ Current Status

Maven **IS INSTALLED AND WORKING** with Java 21 LTS!

```
Apache Maven 3.9.11
Java: 21.0.10 LTS
Location: C:\Maven
```

---

## 🔧 The Issue (Solved!)

PowerShell wasn't finding Maven because the PATH environment variable needed to be updated. This is now fixed!

---

## 💡 How to Use Maven Going Forward

### **Option 1: Quick Setup Script (Easiest)** ✨

Run this ONCE each time you open a **new PowerShell**:

```powershell
& "c:\BasicsFullStackDevelopment\setup-maven.ps1"
```

**That's it!** Maven will work for the rest of that PowerShell session.

### **Option 2: Manual PATH Update** 

In PowerShell, run:

```powershell
$env:PATH = "C:\Maven\bin;$env:PATH"
```

Then Maven will work in that session.

### **Option 3: Current Session** ✅

**Maven is ALREADY working in this current terminal!** Try:

```bash
mvn -v
mvn --version
```

---

## 📋 Setup Scripts Provided

We created two helper scripts for you:

### **setup-maven.ps1** (PowerShell)
- Location: `c:\BasicsFullStackDevelopment\setup-maven.ps1`
- **Best for:** PowerShell users
- **How to use:** 
  ```powershell
  & "c:\BasicsFullStackDevelopment\setup-maven.ps1"
  ```

### **setup-maven.bat** (Command Prompt)
- Location: `c:\BasicsFullStackDevelopment\setup-maven.bat`
- **Best for:** Command Prompt users
- **How to use:** 
  ```cmd
  c:\BasicsFullStackDevelopment\setup-maven.bat
  ```

---

## 🎯 Quick Test

Verify Maven works:

```bash
# All should return version info
mvn --version
java -version
node --version
npm --version
git --version
```

---

## 🚀 Ready to Code!

### Try creating your first Maven project:

```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=HelloWorld -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
cd HelloWorld
mvn clean install
```

### Or start with Java:

```bash
cd c:\BasicsFullStackDevelopment\1-java-basics\1-syntax-basics
javac HelloWorld.java
java HelloWorld
```

---

## 📚 Setup Instructions Cheatsheet

| Task | Command |
|------|---------|
| **Setup Maven (PowerShell)** | `& "c:\BasicsFullStackDevelopment\setup-maven.ps1"` |
| **Setup Maven (Command Prompt)** | `c:\BasicsFullStackDevelopment\setup-maven.bat` |
| **Test Maven** | `mvn -v` |
| **Test Java** | `java -version` |
| **Test Node.js** | `node --version` |
| **Create Maven Project** | `mvn archetype:generate...` (see above) |
| **Compile Java** | `javac FileName.java` |
| **Run Java** | `java FileName` |

---

## ⚡ Pro Tips

1. **Save time**: Create a shortcut to the setup script on your desktop
2. **Permanent fix**: If you want Maven in all PowerShell windows permanently, modify your PowerShell profile (advanced)
3. **Use batch file**: If you prefer Command Prompt, use `setup-maven.bat` instead
4. **Keep this file handy**: Reference this guide whenever you open a new terminal

---

## ✅ Verification Checklist

- [x] Maven installed at `C:\Maven`
- [x] Java 21.0.10 LTS installed
- [x] Node.js v22.18.0 installed 
- [x] npm 9.8.1 installed
- [x] Git 2.50.1 installed
- [x] VS Code installed
- [x] PostgreSQL 18 installed
- [x] Setup scripts created
- [ ] Run setup script and verify Maven works
- [ ] Begin coding!

---

## 🎓 Next Steps

1. **Run the setup script**: `& "c:\BasicsFullStackDevelopment\setup-maven.ps1"`
2. **Verify Maven**: `mvn -v`
3. **Start Level 1**: Open `c:\BasicsFullStackDevelopment\1-java-basics\README.md`
4. **Begin coding!** 🚀

---

**Everything is set up and ready. Happy coding!** 💻
