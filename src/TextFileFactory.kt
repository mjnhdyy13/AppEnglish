import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.FileInputStream


/**
 * Created by cafe on 02/06/2017.
 */
class TextFileFactory {
    /**
     * @author Trần Duy Thanh
     * @param data: Dữ liệu là Danh sách sản phẩm muốn lưu
     * @param path: Đường dẫn lưu trữ
     * @return true nếu lưu thành công, false nếu lưu thất bại
     */
    fun LuuFile(data:MutableList<Vocal>,path:String):Boolean
    {
        try {
            val fos = FileOutputStream(path,true)
            val osw = OutputStreamWriter(fos, "UTF-8")
            val bw = BufferedWriter(osw)
            for (sp in data) {
                bw.write(sp.toString());
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true
        }
        catch (ex:Exception)
        {
            ex.printStackTrace()
        }
        return false
    }

    /**
     * @author Trần Duy Thanh
     * @param path:đường dẫn muốn đọc dữ liệu
     * @return Danh sách sản phẩm MutableList
     */
    fun DocFile(path:String):MutableList<Vocal>
    {
        var data:MutableList<Vocal> = mutableListOf()
        try {
            val fis = FileInputStream(path)
            val isr = InputStreamReader(fis, "UTF-8")
            val br = BufferedReader(isr)

            var line = br.readLine()
            while (line != null) {
                var arr = line.split("\t")
                if (arr.size == 3) {
                    var sp: Vocal = Vocal()
                    sp.english = arr[0]
                    sp.tuloai = arr[1]
                    sp.vietnam = arr[2]
                    data.add(sp)
                }
                line = br.readLine()
            }
            br.close()
            isr.close()
            fis.close()
        }
        catch (ex:Exception)
        {
            ex.printStackTrace()
        }
        return data
    }
}