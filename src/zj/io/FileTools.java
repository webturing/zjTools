package zj.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 * FileIO ver 0.1 by *
 * 
 * @author ZHAO Jing 33470027#qq.com 实现API:文件（夹）拷贝
 */
public class FileTools {
	public static void main(String[] args) {
		// copyFolder("c:/abc", "c:/abc2");
		for (String string : getAllFileList("c:/ide"))
			System.out.println(string);
	}

	/**
	 * 递归完全删除一个目录（包括该目录中的所有目录和子目录）
	 * 
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists()) {
			System.out.println(folder + " not existed!");
			return;
		}
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				delFolder(file.toString());
				file.delete();
			} else
				file.delete();
		}
		folder.delete();
	}

	/*
	 * 拷贝二进制文件到流，为了提高效率Buffer一下是必须的
	 */
	public static void copyContent(File srcFile, PrintStream outStream) {
		try {
			BufferedInputStream fis = new BufferedInputStream(
					new FileInputStream(srcFile));
			for (int c; (c = fis.read()) != -1;)
				outStream.write(c);
			fis.close();
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拷贝srcFile到dstPath目录下，如果该目录不存在则会自动创建
	 * 
	 * @param srcFile
	 *            被拷贝的文件
	 * @param dstPath
	 *            拷贝文件的目标路径
	 */
	public static void copyFile(File srcFile, String dstPath) {
		File dstFile = new File(dstPath.toString());
		if (!dstFile.exists())
			dstFile.mkdirs();
		try {
			PrintStream out = new PrintStream(new BufferedOutputStream(
					new FileOutputStream(new File(dstPath, srcFile.getName()))));
			copyContent(srcFile, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文件拷贝的重载方法
	 * 
	 * @param srcFileName
	 * @param dstFilePath
	 */
	public static void copyFile(String srcFileName, String dstFilePath) {
		copyFile(new File(srcFileName), dstFilePath);

	}

	/**
	 * 文件夹拷贝（递归) 拷贝srcFolderPath到dstFolderPath目录下，如果该目录不存在则会自动创建
	 * 
	 * @param srcFolderPath
	 *            被拷贝的文件夹
	 * @param dstFolderPath
	 *            拷贝文件夹的目标路径
	 */
	public static void copyFolder(String srcFolderPath, String dstFolderPath) {
		for (File file : new File(srcFolderPath).listFiles())
			if (!file.isDirectory())
				copyFile(file, dstFolderPath);
			else
				copyFolder(file.getAbsolutePath(),
						new File(dstFolderPath, file.getName()).toString());

	}

	/**
	 * 递归获得一个文件夹下所有文件名列表 *
	 * 
	 * @param folderPath
	 * @return
	 */
	public static LinkedList<String> getAllFileList(String folderPath) {
		LinkedList<String> list = new LinkedList<String>();
		File temp = new File(folderPath);
		if (temp.isFile())
			list.add(folderPath);
		else if (temp.isDirectory())
			for (String t : temp.list())
				list.addAll(getAllFileList(folderPath + "/" + t));// 递归体
		return list;
	}
}
