# 0. Environment Setup Guide

This guide will help you install all necessary tools for full stack development with Java Spring Boot & Angular.

## 🖥️ System Requirements

- **OS**: Windows 10/11, macOS, or Linux
- **RAM**: Minimum 8GB (16GB recommended)
- **Storage**: 20GB free space
- **Internet**: Required for downloads and dependencies

## 📦 Installation Steps

### 1. Install Java Development Kit (JDK)

**Java is the foundation** - Spring Boot requires Java to run.

#### On Windows:

1. Visit: https://www.oracle.com/java/technologies/downloads/
2. Download **JDK 21** (or latest LTS version)
3. Run the installer and follow prompts
4. Select to add Java to PATH (important!)

**Verify Installation:**
```bash
java -version
javac -version
```

Should show version numbers like: `java version "21.0.x"`

---

### 2. Install Maven

**Maven** helps manage Java dependencies and build projects.

#### On Windows:

1. Visit: https://maven.apache.org/download.cgi
2. Download binary zip (e.g., `apache-maven-3.9.x-bin.zip`)
3. Extract to `C:\Program Files\Apache` (or your preferred location)
4. Add Maven to PATH:
   - Open System Properties → Environment Variables
   - Click "New" for User Variables
   - **Variable name**: `MAVEN_HOME`
   - **Variable value**: `C:\Program Files\Apache\apache-maven-3.9.x`
   - Click OK, then add Maven to PATH:
     - Create new Variable: `Path` → Add `%MAVEN_HOME%\bin`

**Verify Installation:**
```bash
mvn -version
```

Should show: `Apache Maven 3.9.x`

---

### 3. Install Node.js & npm

**Node.js & npm** are needed for Angular frontend development.

#### On Windows:

1. Visit: https://nodejs.org/ (Download LTS version)
2. Run the installer
3. Accept defaults and install

**Verify Installation:**
```bash
node -version
npm -version
```

Should show version numbers like: `v20.x.x` and `10.x.x`

---

### 4. Install Visual Studio Code

**VS Code** is a lightweight, powerful code editor.

#### On Windows:

1. Visit: https://code.visualstudio.com/
2. Download and run installer
3. Accept defaults
4. Install recommended extensions:
   - **Extension Pack for Java** (Microsoft)
   - **Angular Language Service** (Angular)
   - **Prettier** - Code formatter
   - **Thunder Client** or **REST Client** (for API testing)

**Verify**: Open VS Code, should launch without errors

---

### 5. Install Git

**Git** is essential for version control.

#### On Windows:

1. Visit: https://git-scm.com/download/win
2. Download and run installer
3. Accept defaults (Git Bash will be installed)

**Verify Installation:**
```bash
git --version
```

Should show: `git version 2.x.x.windows.x`

---

### 6. Install a Database (PostgreSQL or MySQL)

**Database** is needed for storing application data.

#### PostgreSQL (Recommended):

1. Visit: https://www.postgresql.org/download/
2. Download for Windows
3. During installation:
   - Set password for `postgres` user (save this!)
   - Keep port as 5432 (default)
4. Select "Stack Builder" to install pgAdmin (GUI tool)

**Verify**: Launch pgAdmin from Start Menu

#### MySQL Alternative:

1. Visit: https://dev.mysql.com/downloads/mysql/
2. Download and install
3. Note the root password

---

## ✅ Verify All Installations

Open PowerShell or Git Bash and run:

```bash
java -version
javac -version
mvn -version
node -version
npm -version
git --version
```

**All should show version numbers** (no errors).

---

## 🌐 Configure Global npm Settings

```bash
npm config set legacy-peer-deps true
```

This prevents common npm installation issues.

---

## 🚀 First Command - Verify Maven Works

```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=HelloWorld -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

This creates a sample Java project. If successful, you're ready!

---

## 📝 IDE Extensions to Install (VS Code)

Open VS Code and install these extensions:
1. **Extension Pack for Java** - Microsoft
2. **Spring Boot Extension Pack** - Pivotal
3. **Angular Language Service** - Angular
4. **Thunder Client** - Rangav (for testing APIs)
5. **GitLens** - Eric Amodio
6. **Prettier** - Code formatter

---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| `java: command not found` | Java not in PATH; reinstall or add manually |
| `mvn: command not found` | Maven not in PATH; check MAVEN_HOME |
| `npm: command not found` | Node.js not installed or not in PATH |
| Database won't connect | Check if service is running; verify credentials |
| Port conflicts | Change port in configuration if 8080/5432 are in use |

---

## 🎯 Next Steps

Once all installations are verified, you're ready to:
1. Create your first Java program
2. Learn Object-Oriented Programming
3. Start building Spring Boot applications

**Next**: Go to [Level 1 - Java Basics](../1-java-basics/README.md)

---

**Need Help?** Check each tool's official documentation or community forums.
