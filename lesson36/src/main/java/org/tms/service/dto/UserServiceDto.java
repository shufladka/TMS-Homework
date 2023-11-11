package org.tms.service.dto;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.tms.entity.TaskEntity;
import org.tms.entity.TaskStatus;
import org.tms.entity.UserEntity;
import org.tms.entity.UserType;
import org.tms.service.impl.UserServiceImpl;
import org.tms.service.interfaces.Dto;
import org.tms.service.interfaces.UserService;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class UserServiceDto {

    public static List<UserEntity> searchCriteria(UserEntity userSearch) {

//        UserEntity userSearch = new UserEntity();
        TaskEntity taskSearch = new TaskEntity();

        Session session = Dto.openSessionAndTransaction();
        Criteria userCriteria = session.createCriteria(UserEntity.class, "ue");
        Criteria taskCriteria = session.createCriteria("ue.tasks", "ts");

        List result;

        if (userSearch == null) {
            result = userCriteria.list();
        }
        else {

            // тип пользователя
            if (nonNull(userSearch.getUserType())) {
                userCriteria.add(Restrictions.eq("ue.userType", UserType.USER));
            }

            // диапазон дат рождения
            if (nonNull(userSearch.getDateOfBirth())) {
                userCriteria.add(Restrictions.between("ue.dateOfBirth", LocalDate.parse("2001-01-10"), LocalDate.parse("2015-04-17")));
            }

            // задачи с определенным статусом
            if (nonNull(taskSearch.getTaskStatus())) {
                taskCriteria.add(Restrictions.eq("ts.taskStatus", TaskStatus.DONE));
            }
        }

        result = userCriteria.list();

        Dto.closeSessionAndTransaction(session);

        return result;
    }
}