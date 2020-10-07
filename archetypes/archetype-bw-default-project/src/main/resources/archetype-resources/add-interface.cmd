@ECHO OFF

:: ==============================================================
:: This program is used to add an interface (JMS, DB, HTTP, ...)
:: to an existing TIBCO BusinessWorks 5 project
:: ==============================================================
::
:: HEADER
:Header
ECHO.>CON
ECHO bwAddInterface,  Version 1.00 for Windows>CON
ECHO Adds interfaces (JMS, HTTP, DB, FILE, etc.) to an existing TIBCO BusinessWorks 5.x project>CON

:Check
:: Prepare variables from the given arguments
SET interface=%1
SET bwProjectName=%2
SET INTERFACES_ROOT=tmp-interfaces\interfaces
SET BWPROJECT_ROOT=src\main\tibco\%bwProjectName%

:: Check validity of command line parameters:
:: *** 2 command line parameters needed
IF [%2]==[] GOTO Syntax

:Chk_1
:: ** first parameter must be a valid interface name
IF %interface%==JMS GOTO Chk_2
IF %interface%==HTTP GOTO Chk_2
IF %interface%==DB GOTO Chk_2
IF %interface%==FILE GOTO Chk_2
GOTO :Syntax

:Chk_2
:: * second parameter must be a valid project name
IF NOT EXIST "%BWPROJECT_ROOT%" GOTO Syntax

:: Show selected interface and ProjectName
ECHO.>CON
ECHO interface : %interface%>CON
ECHO bwProjectName : %bwProjectName%>CON

:: Call the chosen interface
IF %interface%==JMS GOTO JMS
IF %interface%==HTTP GOTO HTTP
IF %interface%==DB GOTO DB
IF %interface%==FILE GOTO FILE
GOTO :Syntax

:: ADD JMS INTERFACE
:JMS
ECHO.>CON
ECHO Start adding JMS interface...>CON
:: Generate JMS Interface using maven
ECHO Generate JMS Interface from archetype [archetype-bw-interface-jms]>CON
if not exist tmp-interfaces\NUL MD tmp-interfaces
CD tmp-interfaces
if not exist tmp-interfaces\JMS\NUL call mvn -q archetype:generate -DarchetypeGroupId=io.github.fastcube.factory.tibco.bw.maven -DarchetypeArtifactId=archetype-bw-interface-jms -DarchetypeVersion=1.1.0-SNAPSHOT -DgroupId=com.company.interfaces.jms -DartifactId=interfaces -Dversion=1.0.0-SNAPSHOT -DrootProjectGroupId=io.github.fastcube.factory.tibco -DrootProjectArtifactId=fc-tibco-factory -DrootProjectVersion=1.1.0-SNAPSHOT -DinteractiveMode=false
CD ..
:: Check and Copy useful files
if not exist %BWPROJECT_ROOT%\defaultVars\JMS\NUL MD %BWPROJECT_ROOT%\defaultVars\JMS
COPY %INTERFACES_ROOT%\%interface%\defaultVars\JMS\* %BWPROJECT_ROOT%\defaultVars\JMS\
COPY %INTERFACES_ROOT%\%interface%\Connections\* %BWPROJECT_ROOT%\Connections\
COPY %INTERFACES_ROOT%\%interface%\Processes\* %BWPROJECT_ROOT%\%bwProjectName%\
:: Replace project name in some processes
SET JMS_PROCESS_FILE=%BWPROJECT_ROOT%\%bwProjectName%\SampleJMSProcess.process
powershell -Command "(gc %JMS_PROCESS_FILE%) -replace '__bwProjectName__', '%bwProjectName%' | Out-File -encoding ASCII %JMS_PROCESS_FILE%"
:: COPY %INTERFACES_ROOT%\%interface%\Schemas\* %BWPROJECT_ROOT%\Schemas\
ECHO JMS interface added successfully>CON
GOTO CLEAN

:: ADD HTTP INTERFACE
:HTTP
ECHO.>CON
ECHO Start adding HTTP interface...>CON
:: Generate HTTP Interface using maven
ECHO Generate HTTP Interface from archetype [archetype-bw-interface-http]>CON
if not exist tmp-interfaces\NUL MD tmp-interfaces
CD tmp-interfaces
if not exist tmp-interfaces\HTTP\NUL call mvn -q archetype:generate -DarchetypeGroupId=io.github.fastcube.factory.tibco.bw.maven -DarchetypeArtifactId=archetype-bw-interface-http -DarchetypeVersion=1.1.0-SNAPSHOT -DgroupId=com.company.interfaces.http -DartifactId=interfaces -Dversion=1.0.0-SNAPSHOT -DrootProjectGroupId=io.github.fastcube.factory.tibco -DrootProjectArtifactId=fc-tibco-factory -DrootProjectVersion=1.1.0-SNAPSHOT -DinteractiveMode=false
CD ..
:: Check and Copy useful files
if not exist %BWPROJECT_ROOT%\defaultVars\HTTP\NUL MD %BWPROJECT_ROOT%\defaultVars\HTTP
COPY %INTERFACES_ROOT%\%interface%\defaultVars\HTTP\* %BWPROJECT_ROOT%\defaultVars\HTTP\
COPY %INTERFACES_ROOT%\%interface%\Connections\* %BWPROJECT_ROOT%\Connections\
COPY %INTERFACES_ROOT%\%interface%\Processes\* %BWPROJECT_ROOT%\%bwProjectName%\
:: Replace project name in the process
SET HTTP_PROCESS_FILE=%BWPROJECT_ROOT%\%bwProjectName%\SampleHTTPProcess.process
powershell -Command "(gc %HTTP_PROCESS_FILE%) -replace '__bwProjectName__', '%bwProjectName%' | Out-File -encoding ASCII %HTTP_PROCESS_FILE%"
ECHO HTTP interface added successfully>CON
GOTO CLEAN

:: ADD DB INTERFACE
:DB
ECHO.>CON
ECHO DB interface is not implemented yet>CON
GOTO CLEAN

:: ADD FILE INTERFACE
:FILE
ECHO.>CON
ECHO FILE interface is not implemented yet>CON
GOTO CLEAN

:: EOF
GOTO :CLEAN

:: Show the syntax of the command
:Syntax
ECHO.>CON
ECHO add-interface.cmd INTERFACE BWPROJECTNAME>CON
ECHO example: add-interface.cmd HTTP SampleProject>CON
ECHO.>CON
ECHO This script needs 2 parameters the 1st one is the interface name and the 2nd is BW ProjectName>CON
ECHO.>CON
::
:: Clean Workspace
:CLEAN
ECHO.>CON
ECHO cleaning workspace...>CON
if exist tmp-interfaces\NUL RMDIR /Q /S tmp-interfaces
ECHO workspace cleaned!
::
:: END OF SCRIPT