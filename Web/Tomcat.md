## 정의
- Tomcat은 Servlet(HTTP 요청과 응답을 처리하는 클래스)을 실행할 수 있는 Web Application Server(WAS)이다.
- Web Server와 연동이 가능하기때문에 정적 컨텐츠는 Web Server에서 처리하도록 할 수 있다. 물론 Tomcat도 Web Server를 내장하고 있긴하다. 
- Tomcat은 Servlet의 Life Cycle 관리를 위한 Servlet Container를 내장하고 있다. 
- Servlet Container는 사용자 요청에 대한 적절한 Servlet을 선택한다. Servlet은 HTML로 변환되어 사용자에게 제공된다.

## Bootstrap.java
- Tomcat을 실행하면 Bootstrap.java의 main 메소드가 실행된다. 
- 톰캣 실행명령어가 "start"인 경우 init() -> load() -> start() 실행

```java
/**
     * Main method and entry point when starting Tomcat via the provided
     * scripts.
     *
     * @param args Command line arguments to be processed
     */
    public static void main(String args[]) {

        synchronized (daemonLock) {
            if (daemon == null) {
                // Don't set daemon until init() has completed
                Bootstrap bootstrap = new Bootstrap();
                try {
                    bootstrap.init();
                } catch (Throwable t) {
                    handleThrowable(t);
                    t.printStackTrace();
                    return;
                }
                daemon = bootstrap;
            } else {
                // When running as a service the call to stop will be on a new
                // thread so make sure the correct class loader is used to
                // prevent a range of class not found exceptions.
                Thread.currentThread().setContextClassLoader(daemon.catalinaLoader);
            }
        }

        try {
            String command = "start";
            if (args.length > 0) {
                command = args[args.length - 1];
            }

            if (command.equals("startd")) {
                args[args.length - 1] = "start";
                daemon.load(args);
                daemon.start();
            } else if (command.equals("stopd")) {
                args[args.length - 1] = "stop";
                daemon.stop();
            } else if (command.equals("start")) {
                daemon.setAwait(true);
                daemon.load(args);
                daemon.start();
                if (null == daemon.getServer()) {
                    System.exit(1);
                }
            } else if (command.equals("stop")) {
                daemon.stopServer(args);
            } else if (command.equals("configtest")) {
                daemon.load(args);
                if (null == daemon.getServer()) {
                    System.exit(1);
                }
                System.exit(0);
            } else {
                log.warn("Bootstrap: command \"" + command + "\" does not exist.");
            }
        } catch (Throwable t) {
            // Unwrap the Exception for clearer error reporting
            if (t instanceof InvocationTargetException &&
                    t.getCause() != null) {
                t = t.getCause();
            }
            handleThrowable(t);
            t.printStackTrace();
            System.exit(1);
        }
    }
```



