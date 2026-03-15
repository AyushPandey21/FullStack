# Setup Maven in PowerShell
# Run this file to add Maven to PATH for current session

Write-Host "`n========================================" -ForegroundColor Cyan
Write-Host "      Maven PATH Setup (PowerShell)    " -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Add Maven to PATH
$env:PATH = "C:\Maven\bin;$env:PATH"

Write-Host "✅ Maven bin directory added to PATH" -ForegroundColor Green
Write-Host ""

# Test Maven
Write-Host "Testing Maven installation:" -ForegroundColor Yellow
mvn -version

Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "✅ Maven is ready to use!" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host "`nTip: If Maven is not found again, run this script again.`n" -ForegroundColor Cyan
