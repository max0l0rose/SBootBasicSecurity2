package rc.bootsecurity.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//@Component("NumberProvider")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@SessionScope
public class NumberProvider {
    int n = 0;

    public int getN() {
        int res = n;
        n++;
        return res;
    }
//	public void setN(int n) {
//		this.n = n;
//	}
}