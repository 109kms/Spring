package org.shark.file.service.task;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.shark.file.repository.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 매일 1회(새벽 3시), "어제" 날짜의 폴더(/upload/yyyy/MM/dd)에 저장된 파일들 중에서
 * 데이터베이스 테이블에 정보가 없는 첨부파일들을 찾아서 자동으로 삭제하는 스케쥴러.
 */

@Service  //----- @Component 등록도 가능합니다.
public class FileCleanupScheduler {

  @Autowired
  private NoticeDAO noticeDAO;
  
  @Scheduled(cron = "0 0 3 * * *")  //----- 매일 새벽 3시를 의미하는 "크론식"을 작성합니다. @Scheduled(cron = "초 분 시 일 월 요일")
                                    //      스케쥴러 동작 허용을 위한 @EnableScheduling 어노테이션 또는 <task:accotation-driven /> 태그가 필요합니다.
  public void cleaupUnusedFiles() {
    
    //----- 1. 어제 날짜의 폴더 경로 계산하기
    LocalDate yesterday = LocalDate.now().minusDays(1);
    String dirPath = "/upload" + yesterday.format(DateTimeFormatter.ofPattern("/yyyy/MM/dd"));
    
    //----- 2. 해당 폴더의 파일 목록 조회하기
    File dir = new File(dirPath);
    if (!dir.exists() || !dir.isDirectory()) {
      return;
    }
    File[] files = dir.listFiles();
    List<String> storedFilenames = Arrays.stream(files)
                                    .map(file -> file.getName())
                                    .collect(Collectors.toList());
    
    //----- 3. DB에서 해당 경로를 가진 첨부파일 목록 조회하기
    
    
    //----- 4. 비교 및 삭제하기
    
  }
  
}
