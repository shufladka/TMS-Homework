package org.tms.service.search;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.tms.entity.TaskEntity;
import org.tms.entity.additions.TaskStatus;
import org.tms.entity.UserEntity;
import org.tms.entity.additions.UserType;
import org.tms.service.interfaces.DAO;

import java.time.LocalDate;
import java.util.List;
import static java.util.Objects.nonNull;

public class CriteriaSearch {

    public static List<UserEntity> personCriteria(UserEntity userSearch) {

//        UserEntity userSearch = new UserEntity();
        TaskEntity taskSearch = new TaskEntity();

        Session session = DAO.openSessionAndTransaction();
        Criteria criteria = session.createCriteria(UserEntity.class, "ue");
        Criteria taskCriteria = session.createCriteria("ue.tasks", "ts");

        List result;
        if (userSearch == null) {
            result = criteria.list();
            DAO.closeSessionAndTransaction(session);
            return result;
        }
        else {
            // тип пользователя
            if (nonNull(userSearch.getUserType())) {
                criteria.add(Restrictions.eq("ue.userType", userSearch.getUserType()));
            }

            // диапазон дат рождения
            if (nonNull(userSearch.getDateOfBirth())) {
                criteria.add(Restrictions.between("ue.dateOfBirth", LocalDate.parse("2001-01-10"), LocalDate.parse("2015-04-17")));
            }

            // задачи с определенным статусом
            if (nonNull(taskSearch.getTaskStatus())) {
                taskCriteria.add(Restrictions.eq("ts.taskStatus", taskSearch.getTaskStatus()));
            }
        }

        result = criteria.list();

        DAO.closeSessionAndTransaction(session);

        return result;
    }
}