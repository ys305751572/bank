package bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sixmac.entity.EmCust;
import com.sixmac.entity.vo.EmCustVo;

/**
 * POI读取Excel示例，分2003和2007
 * 
 * @author Nanlei
 * 
 */
public class ImportExcel {
	private static String xlsx2007 = "d:\\明细清单.xlsx";

	/**
	 * 读取Excel2003的示例方法
	 * 
	 * @param filePath
	 * @return
	 */
	private static List<EmCustVo> readFromXLS2003(String filePath) {
		File excelFile = null;// Excel文件对象
		InputStream is = null;// 输入流对象
		String cellStr = null;// 单元格，最终按字符串处理
		EmCustVo entity = null;// 每一个学生信息对象
		List<EmCustVo> list = new ArrayList<EmCustVo>();
		try {
			excelFile = new File(filePath);
			is = new FileInputStream(excelFile);// 获取文件输入流
			XSSFWorkbook workbook2003 = new XSSFWorkbook(is);// 创建Excel2003文件对象
			XSSFSheet sheet = workbook2003.getSheetAt(0);// 取出第一个工作表，索引是0
			// 开始循环遍历行，表头不处理，从1开始
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				entity = new EmCustVo();// 实例化Student对象
				XSSFRow row = sheet.getRow(i);// 获取行对象
				if (row == null) {// 如果为空，不处理
					continue;
				}
				// 循环遍历单元格
				for (int j = 0; j < row.getLastCellNum(); j++) {
					XSSFCell cell = row.getCell(j);// 获取单元格对象
					if (cell == null) {// 单元格为空设置cellStr为空串
						cellStr = "";
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理
						cellStr = String.valueOf(cell.getBooleanCellValue());
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理
						cellStr = cell.getNumericCellValue() + "";
					} else {// 其余按照字符串处理
						cellStr = cell.getStringCellValue();
					}
					// 下面按照数据出现位置封装到bean中
					if (j == 1) {
						entity.setWnumber(cellStr);
					} else if (j == 2) {
						entity.setName(cellStr);
					} else if (j == 3) {
						entity.setMobile(cellStr);
					} else if(j == 4) {
						entity.setCustomerId(cellStr);
					} else if(j == 5) {
						entity.setCustomerName(cellStr);
					} else if(j == 6) {
						entity.setBf(Double.parseDouble(cellStr));
					} else if(j == 7) {
//						entity.setBe(Double.parseDouble(cellStr));
					} else if(j == 8) {
						double m = Double.parseDouble(cellStr);
						entity.setYear((int)m);
					} else if(j == 9) {
						entity.setBeInsuranceName(cellStr);
					} else if(j == 10) {
						double m = Double.parseDouble(cellStr);
						entity.setLimit((int)m);
					} 
					 
				}
				list.add(entity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {// 关闭文件流
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 主函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start...");
		long start = System.currentTimeMillis();
		List<EmCustVo> list = readFromXLS2003(xlsx2007);
//		for (EmCustVo student : list) {
//			System.out.println(student);
//		}
		System.out.println(list.size());
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms done!");
	}
}
