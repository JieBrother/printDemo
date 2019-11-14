package com.nnxy.print.dao;

import com.nnxy.print.entity.Print;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PrintMapper {

    @Insert("insert into print(registerNum,size,printStyle,printColor,note,gmtCreate,gmtModify)"+
            "values(#{registerNum},#{size},#{printStyle},#{printColor},#{note},#{gmtCreate},#{gmtModify})")
    Integer insert(Print print);
}
