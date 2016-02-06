using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace c_sharp
{
    class Program
    {
        static void Main(string[] args)
        {
            String studentName = "Bob";

            if (args.Length == 1) {
                studentName = args[0];
            }

            StudentService.MainClient client = new StudentService.MainClient();
            StudentService.student student = client.getStudent(studentName);

            Console.WriteLine("student:");
            Console.WriteLine("\tnaam:\t\t" + student.naam);
            Console.WriteLine("\tleeftijd:\t" + student.leeftijd);
            Console.WriteLine("\tgeslacht:\t" + student.geslacht);
        }
    }
}
