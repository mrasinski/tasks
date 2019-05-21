call runcrud.bat
if "%ERRORLEVEL%" == "0" goto showtasks
echo.
goto fail

:showtasks
start chrome http://localhost:8080/crud/v1/tasks/getTasks
goto end

:fail
echo.
echo Error appeared

:end
echo.
echo Here are your tasks