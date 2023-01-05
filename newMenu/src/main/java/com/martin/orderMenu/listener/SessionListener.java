package com.martin.orderMenu.listener;

import com.martin.orderMenu.vo.session.Session_VO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.*;

@Component
@Slf4j
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{

    @Autowired
    private Session_VO sessionVo;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        HttpSessionListener.super.sessionCreated(se);
        log.info("HttpSessionListener: Session Created");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        HttpSessionAttributeListener.super.attributeAdded(se);
        log.info("HttpSessionAttributeListener: Session Attribute Added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        HttpSessionAttributeListener.super.attributeRemoved(se);
        log.info("HttpSessionAttributeListener: Session Attribute Removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        HttpSessionAttributeListener.super.attributeReplaced(se);
        log.info("HttpSessionAttributeListener: Session Attribute Replaced");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionVo.deleteById(se.getSession().getId());
        HttpSessionListener.super.sessionDestroyed(se);
        log.info("HttpSessionListener: Session Destroyed, Id : {}"
                ,se.getSession().getId());
    }
}
