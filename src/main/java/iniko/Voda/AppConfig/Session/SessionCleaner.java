package iniko.Voda.AppConfig.Session;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionCleaner implements DisposableBean {
    @Autowired
    private HttpSession session;

    @Override
    public void destroy() throws Exception {
        session.invalidate();
    }
}
