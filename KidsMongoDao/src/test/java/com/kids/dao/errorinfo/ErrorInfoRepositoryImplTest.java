package com.kids.dao.errorinfo;

import com.kids.KidsMongoDaoApplication;
import com.kids.dao.model.ErrorInfo;
import com.kids.dao.repository.ErrorInfoRepository;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KidsMongoDaoApplication.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorInfoRepositoryImplTest {

    @Autowired
    public ErrorInfoRepository errorInfoRepository;

    @Before
    public void setUp(){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode("10000");
        errorInfo.setErrorMessageTh("ระบบไม่สามารถใช้บริการได้ในขณะนี้กรุณาลองใหม่ภายหลัง");
        errorInfo.setErrorMessageEn("Service is not available at this moment. Please try again later.");
        errorInfo.setCreateDate(LocalDateTime.now().toDate());
        errorInfo.setCreateBy("Admin");

        ErrorInfo errorInfo2 = new ErrorInfo();
        errorInfo2.setErrorCode("10001");
        errorInfo2.setErrorMessageTh("มีผู้เข้าใช้งานด้วยชื่อผู้ใช้งานเดียวกัน");
        errorInfo2.setErrorMessageEn("Invalid Session");
        errorInfo2.setCreateDate(LocalDateTime.now().toDate());
        errorInfo2.setCreateBy("Admin");

        ErrorInfo errorInfo3 = new ErrorInfo();
        errorInfo3.setErrorCode("10002");
        errorInfo3.setErrorMessageTh("ขออภัยไม่มีข้อมูลที่ต้องการค้นหา");
        errorInfo3.setErrorMessageEn("Not found any data.");
        errorInfo3.setCreateDate(LocalDateTime.now().toDate());
        errorInfo3.setCreateBy("Admin");

        List<ErrorInfo> errorInfoList = new ArrayList<>();
        errorInfoList.add(errorInfo);
        errorInfoList.add(errorInfo2);
        errorInfoList.add(errorInfo3);

        errorInfoRepository.deleteAll();
        errorInfoRepository.saveAll(errorInfoList);

    }

    @Test
    public void findAll() {
        assertEquals(3,errorInfoRepository.findAll().size());
    }

    @Test
    public void findByErrorCode_not_found_data() {
        assertNull(errorInfoRepository.findByErrorCode("10009"));
    }

    @Test
    public void findByErrorCode_found_data() {
        assertEquals("10001",errorInfoRepository.findByErrorCode("10001").getErrorCode());
    }

    @Test
    public void update_success() {

        ErrorInfo errorInfo = errorInfoRepository.findByErrorCode("10001");

        Date oldDate = errorInfo.getModifyDate();
        String oldModifyBy = errorInfo.getModifyBy();
        errorInfo.setErrorMessageTh("ทดสอบ");
        errorInfo.setErrorMessageEn("test");
        errorInfo.setModifyBy("Admin");
        errorInfo.setModifyDate(LocalDateTime.now().toDate());

        ErrorInfo result = errorInfoRepository.update(errorInfo);

        assertEquals(result.getErrorMessageEn(),errorInfo.getErrorMessageEn());
        assertEquals(result.getErrorMessageTh(),errorInfo.getErrorMessageTh());
        assertNotEquals(result.getModifyDate(),oldDate);
        assertNotEquals(result.getModifyBy(),oldModifyBy);

    }

    @Test
    public void save_success() {

        int before = errorInfoRepository.findAll().size();

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode("10003");
        errorInfo.setErrorMessageEn("User role not authorized");
        errorInfo.setErrorMessageTh("กลุ่มผู้ใช้งานไม่มีสิทธิใช้งานบริการ");
        errorInfo.setCreateDate(LocalDateTime.now().toDate());
        errorInfo.setCreateBy("Admin");

        errorInfoRepository.save(errorInfo);

        int after = errorInfoRepository.findAll().size();

        assertEquals(before + 1,after);

    }

    @Test(expected = Exception.class)
    public void save_fail_with_duplicates_key() {

        int before = errorInfoRepository.findAll().size();

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode("10003");
        errorInfo.setErrorMessageEn("User role not authorized");
        errorInfo.setErrorMessageTh("กลุ่มผู้ใช้งานไม่มีสิทธิใช้งานบริการ");
        errorInfo.setCreateDate(LocalDateTime.now().toDate());
        errorInfo.setCreateBy("Admin");

        errorInfoRepository.save(errorInfo);

        int after = errorInfoRepository.findAll().size();

        assertEquals(before + 1,after);

    }

    @Test
    public void delete_success() {

        int before = errorInfoRepository.findAll().size();

        ErrorInfo errorInfo = errorInfoRepository.findByErrorCode("10003");

        errorInfoRepository.delete(errorInfo);

        int after = errorInfoRepository.findAll().size();

        assertEquals(before - 1,after);
    }

    @Test
    public void delete_fail_with_null_obj() {
        errorInfoRepository.delete(null);
    }

}
