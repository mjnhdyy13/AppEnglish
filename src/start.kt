import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter

fun main(arg: Array<String>) {
    System.out.println("APP ENGLISH")
    System.out.println("Chức năng:")
    System.out.println("1.Thêm từ vựng")
    System.out.println("2.Danh sách từ vựng")
    System.out.println("6. Thoát")
    System.out.println("5. Kiểm tra từ vựng")
    System.out.println("4. Xóa toàn bộ")
    System.out.println("Your choice?")

    var luachon = readLine()
    var data: MutableList<Vocal> = mutableListOf()
    do {
    if (luachon == "1") {
        System.out.println("Nhập từ vựng or Nhập end để thoát")
        do {
            var v = readLine()
            if (v == "end") {
                break
            }
            var ar = v!!.split(",")
            if (ar.size == 3) {
                var tv: Vocal = Vocal()
                tv.english = ar[0]
                tv.tuloai = ar[1]
                tv.vietnam = ar[2]
                data.add(tv)
                System.out.println("Đã thêm từ")
            }
        } while (v != "end")

        var kqLuu = TextFileFactory().LuuFile(data, "A:/dulieusanpham.txt")
        if (kqLuu) {
            println("Lưu text file thành công")
        } else {
            println("Lưu text file thất bại")
        }

    }

    if (luachon == "2"){
        var data:MutableList<Vocal> =
                TextFileFactory().DocFile("A:/dulieusanpham.txt")
        for (sp in data)
            println(sp)
    }

    if (luachon == "4"){
        val fos = FileOutputStream("A:/dulieusanpham.txt")
        val osw = OutputStreamWriter(fos, "UTF-8")
        val bw = BufferedWriter(osw)
        bw.write("")
        bw.close();
        osw.close();
        fos.close();
        System.out.println("Đã xóa xong")
    }
    if(luachon == "5"){
        var data:MutableList<Vocal> =
                TextFileFactory().DocFile("A:/dulieusanpham.txt")
        var thoat : Boolean = false

        for (sp in data) {
            println("......\t${sp.tuloai}\t${sp.vietnam}")
            println("please you write")
            do {
            var asw = readLine()
            if (asw == "thoat"){
                thoat = true
                break
            }
            var tru : Boolean  = false
            if (asw == sp.english) {
                System.out.println("you right")
                tru = true
                break
            }else {
                System.out.println("you wrong")
            }
            }while (tru == false)
        if (thoat == true) {
            System.out.println("Đã thoát kiểm tra ")
            break
        }

        }
    }

    luachon = readLine()

    }while (luachon != "6")
    System.out.println("Bye Bye")

}




