package br.com.projectapi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtils {

    /**
     * MÉTODO PARA DESCOMPACTAR UM ARQUIVO ZIP QUE CONTENHA UMA LISTA (UM ARQUIVO ZIP COM VÁRIOS JSON POR EXEMPLO)
     *
     * @param arquivoParaDescompactar
     * @return
     * @throws Exception
     */
    public static File UnzipFileList(File arquivoParaDescompactar) throws Exception {
        List<File> resultFile = new ArrayList<>();
        byte[] buffer = new byte[1024];

        try (ZipInputStream ziz = new ZipInputStream(new FileInputStream((arquivoParaDescompactar)))) {
            ZipEntry zipEntry = ziz.getNextEntry();
            File destDir = arquivoParaDescompactar.getParentFile();

            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        int len;
                        while ((len = ziz.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    } catch (Exception e) {
                        System.out.println("Error Unzip file");
                    }
                    resultFile.add(newFile);
                }
                ziz.closeEntry();
                zipEntry = ziz.getNextEntry();
            }
            return destDir;
        }
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws Exception {
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
        return new File(destinationDir, destFile.getName());
    }

    /**
     * MÉTODO PARA DESCOMPACTAR UM ARQUIVO ZIP QUE CONTENHA UM UNICO ARQUIVO (UM CSV, UM JSON, OU OUTRO ARQUIVO, POR EXEMPLO)
     *
     * @param arquivoParaDescompactar
     * @return
     * @throws IOException
     */
    public static File unzipFileSimple(File arquivoParaDescompactar) throws IOException {
        File resultFile = null;
        File zipFileName = arquivoParaDescompactar;
        String destDirectory = arquivoParaDescompactar.getParent();
        byte[] buffer = new byte[1024];

        try (ZipInputStream ziz = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry zipEntry = ziz.getNextEntry();
            while (zipEntry != null) {
                String filePath = destDirectory + File.separator + zipEntry.getName();
                resultFile = new File(filePath);

                if (!zipEntry.isDirectory()) {

                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        int len;
                        while ((len = ziz.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    } catch (Exception e) {
                        System.out.println("Error unzip file");
                    }
                } else {
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                ziz.closeEntry();
                zipEntry = ziz.getNextEntry();
            }
            ziz.closeEntry();
        }
        return resultFile;
    }
}
