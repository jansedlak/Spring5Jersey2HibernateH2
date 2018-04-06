package sk.js.spring.jersey2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.js.spring.jersey2.api.service.DummyService;
import sk.js.spring.jersey2.dao.UserDaoImpl;
import sk.js.spring.jersey2.model.User;

@Component
public class DummyServiceImpl implements DummyService {

    @Autowired
    private UserDaoImpl genericDao;

    @Transactional(readOnly = true)
    @Override
    public String getName() {
        final User newUser = new User();
        newUser.setFirstName("Janko");
        genericDao.create(newUser);
        return "Dummy name:" + newUser.getFirstName();
    }

}
