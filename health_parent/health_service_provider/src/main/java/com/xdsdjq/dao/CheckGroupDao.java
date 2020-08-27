package com.xdsdjq.dao;

import com.xdsdjq.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupDao {
    void addCheckGroup(CheckGroup checkGroup);

    void addCheckGroupAndCheckItem(@Param("checkGroupId") Integer checkGroupId, @Param("checkItemId") Integer checkItemId);

    List<CheckGroup> selectByCondition(@Param("queryString") String queryString);

    void deleteGroupAndItemByGroupId(Integer id);

    void deleteCheckGroupById(Integer id);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdByGId(Integer id);

    void editGroupAndItemsByCheckGroupId(@Param("checkGroupId") Integer checkGroupId, @Param("checkItemId") Integer checkItemId);

    void editCheckGroup(CheckGroup checkGroup);

    List<CheckGroup> findAll();
}
