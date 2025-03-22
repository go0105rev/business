SET CURRENT=C:\pleiades
SET PATH=2024-06\workspace\business\elearningBatch
SET BATCH_HOME=%CURRENT%\elearning_batch
SET LIST=%CURRENT%\%PATH%\src\main\bash\release.lst
SET M2=C:\Users\go

rd /s /q %BATCH_HOME%
mkdir %BATCH_HOME%\lib
mkdir %BATCH_HOME%\bash

copy %CURRENT%\%PATH%\src\main\bash\executor.sh %BATCH_HOME%\bash
copy %CURRENT%\%PATH%\target\elearningBatch-1.0.0.jar %BATCH_HOME%\lib\

for /f "tokens=1,2" %%a in (%LIST%) do (
    if %%a==rem (
        echo %%b
    ) else (
        copy /y %M2%\%%a %BATCH_HOME%\lib\
    )
)