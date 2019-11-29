package student.enterprise.project.service;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.repository.GroupRepository;
import student.enterprise.project.service.impl.GroupService;

public class GroupServiceTest {

  private GroupRepository groupRepository;

  private GroupService groupService;

  @Before
  public void setUp() {
    groupRepository = Mockito.mock(GroupRepository.class);

    assertTrue(MockUtil.isMock(groupRepository));

    groupService = new GroupService(groupRepository);

    assertFalse(MockUtil.isMock(groupService));
  }

  @Test
  //TODO fill given entity and expected result
  public void getAllChanges() {
    //Given
    final GroupEntity givenGroupEntity = GroupEntity.builder().build();
    final List<ChangeEntity> expectedResult = Lists.newArrayList();

    //When
    final List<ChangeEntity> result = groupService.getAllChanges(givenGroupEntity);

    //Then
    assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
