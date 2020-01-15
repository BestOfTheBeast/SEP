package student.enterprise.project.service.impl;

import student.enterprise.project.converter.impl.ChangeEntityConverter;
import student.enterprise.project.service.ChangeService;

//TODO rename service
public class ChangeServiceImpl extends ChangeService {

  public ChangeServiceImpl(ChangeEntityConverter changeConverter) {
    super(changeConverter);
  }

}
