using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.utils
{
    public class Log
    {
      
        private static StreamWriter writer;
        private static FileStream fileStream = null;
        public const int OF_READWRITE = 2;
        public const int OF_SHARE_DENY_NONE = 0x40;
        public static readonly IntPtr HFILE_ERROR = new IntPtr(-1);  
        public  Log(string fileName)
        {
            fileName = "D:\\testLog\\log.txt";
           // logFile = fileName;
            //CreateDirectory(logFile);
        }

        public static void writelog(string info)
        {

            try
            {
        /*
                
                string basePath = Application.StartupPath;
                string logFile = basePath + "\\testLog\\log.txt";
                DirectoryInfo directoryInfo = Directory.GetParent(logFile);
                if (!directoryInfo.Exists)
                {
                    directoryInfo.Create();
                }
                System.IO.FileInfo fileInfo = new System.IO.FileInfo(logFile);
                if (!fileInfo.Exists)
                {
                    fileStream = fileInfo.Create();
                    writer = new StreamWriter(fileStream);
                }
                else
                {
                    fileStream = fileInfo.Open(FileMode.Append, FileAccess.Write);
                    writer = new StreamWriter(fileStream);
                }
                DateTime t = DateTime.Now;
               // Console.WriteLine(t.ToString("yyyy-MM-dd hh:mm:ss fff"));
               // writer.WriteLine(t.ToString() + ": " + info);
                writer.WriteLine(t.ToString("yyyy-MM-dd hh:mm:ss fff") + ": " + info);*/

            }catch//(Exception ex)
            {
                
            }
            finally
            {
                if (writer != null)
                {
                    writer.Close();
                    writer.Dispose();
                    fileStream.Close();
                    fileStream.Dispose();
                }
            }
        }

        public   void CreateDirectory(string infoPath)
        {
            DirectoryInfo directoryInfo = Directory.GetParent(infoPath);
            if (!directoryInfo.Exists)
            {
                directoryInfo.Create();
            }
        }
    }  
}
