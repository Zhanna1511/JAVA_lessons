package ru.Bykova.JAVA_lessons.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {

    private final ApplicationManager app;
    private FTPClient ftp;

    public FtpHelper(ApplicationManager app) {
        this.app = app;
        ftp = new FTPClient();
    }

    public void upload(File file, String target, String backup) throws IOException {//метод загружает новый файл,старый временно переименовывает
        ftp.connect(app.getProperty("ftp.host"));//устан-ся соед-е
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));//вып-ся логин
        ftp.deleteFile(backup);//удал-м предыдущ.резервн.копию
        ftp.rename(target, backup);//переименов-ем удален-й файл,делаем резервн копию
        ftp.enterLocalPassiveMode();//вкл-ся пассив-й режим передачи данных
        ftp.storeFile(target, new FileInputStream(file));//передается файл
        ftp.disconnect();//соед-е разрывается
    }

    public void restore(String backup, String target) throws IOException {//метод восстанавливает старый файл (исх.конфиг-ю тестиру-ой системы)
        ftp.connect(app.getProperty("ftp.host"));//уст-ся соед-е с уд.машиной
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));//вып-ся вход
        ftp.deleteFile(target);//уд-ся тот файл,кот.в начале загрузили
        ftp.rename(backup, target);//восс-ся оригин-ый файл из резервной копии
        ftp.disconnect();//соед-е разорвано
    }
}