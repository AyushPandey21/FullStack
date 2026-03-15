@echo off
REM Maven Setup Batch File
REM This adds Maven to PATH for the current session

echo.
echo ========================================
echo      Maven PATH Setup
echo ========================================
echo.

REM Add Maven to PATH
set PATH=C:\Maven\bin;%PATH%

echo Maven bin directory added to PATH
echo.

REM Test Maven
echo Testing Maven installation:
mvn -version

echo.
echo ========================================
echo Maven is ready to use in this session!
echo ========================================
echo.
pause
