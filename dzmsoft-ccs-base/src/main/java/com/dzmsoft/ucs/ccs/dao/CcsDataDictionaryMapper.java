package com.dzmsoft.ucs.ccs.dao;

import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionary;
import com.dzmsoft.ucs.ccs.pojo.CcsDataDictionaryExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcsDataDictionaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int countByExample(CcsDataDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int deleteByExample(CcsDataDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int insert(CcsDataDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int insertSelective(CcsDataDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    List<CcsDataDictionary> selectByExample(CcsDataDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    CcsDataDictionary selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int updateByExampleSelective(@Param("record") CcsDataDictionary record, @Param("example") CcsDataDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int updateByExample(@Param("record") CcsDataDictionary record, @Param("example") CcsDataDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int updateByPrimaryKeySelective(CcsDataDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    int updateByPrimaryKey(CcsDataDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccs_data_dictionary
     *
     * @mbggenerated Sat Nov 19 08:49:31 CST 2016
     */
    PageList<CcsDataDictionary> selectByExample(CcsDataDictionaryExample example, PageBounds pageBounds);
}