using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.IO;

/******************************************************
 *************** EDUCACIENCIA FAST CODE ***************
 *************** CHAMADA REST - API JAVA **************
 ******************************************************/

namespace Consummer_API_Java
{
    class Program
    {

        static void Main(string[] args)
        {
             //Get_API_Java();
             //Get_API_Java2();
             //Post_API_Java();
             //Update_API_Java();
             //Delete_API_Java();
            Console.ReadKey();
        }


        /** GET */
        public static void Get_API_Java2()
        {
            WebClient webClient = new WebClient();
            string content = webClient.DownloadString("http://localhost:8080/api/JPA/educaciencia/clientes/get");
            Console.Write(content+"\n");
        }

        /** GET */
        public static void Get_API_Java()
        {
            WebRequest request = WebRequest.Create("http://localhost:8080/api/JPA/educaciencia/clientes/get");
            request.Method = "GET";
            var response = request.GetResponse();

            if (((HttpWebResponse)response).StatusCode == HttpStatusCode.OK)
            {
                using (Stream stream = response.GetResponseStream())
                {
                    StreamReader streamReader = new StreamReader(stream);
                    string content = streamReader.ReadToEnd();
                    Console.Write("GET" + content + "\n");
                }
            }
            else
            {
                Console.Write("GET Fail");
            }
        }

        /** POST */
        public static void Post_API_Java()
        {
            WebRequest request = WebRequest.Create("http://localhost:8080/api/JPA/educaciencia/clientes/post");
            request.Method = "POST";
            request.ContentType = "application/json; charset=UTF-8";
            string json = "{\"nome\":\"EducaCiencia FastCode\",\"email\":\"eduaciencia-fastcode@outlook.com.br\"}";

            var byteArray = Encoding.UTF8.GetBytes(json);
            request.ContentLength = byteArray.Length;

            Stream stream = request.GetRequestStream();
            stream.Write(byteArray, 0, byteArray.Length);
            stream.Close();

            var response = (HttpWebResponse)request.GetResponse();
            if (response.StatusCode == HttpStatusCode.OK)
            {
                Console.Write("Post https://600607e63698a80017de12e2.mockapi.io/fp => ok \n");
            }
            else
            {
                Console.Write("fail Post \n");
            }
        }
        
        /** PUT */
        public static void Update_API_Java()
        {
            int id = 4;
            WebRequest request = WebRequest.Create("http://localhost:8080/api/JPA/educaciencia/clientes/put/"+ id);
            request.Method = "PUT";
            request.ContentType = "application/json; charset=UTF-8";
            string json = "{" + "\"id\":\"4\"," + "\"nome\":\"update.Eduaciencia Fastcode\","
                    + "\"email\":\"update.eduaciencia-fastcode@outlook.com.br\"" + "}";

            var byteArray = Encoding.UTF8.GetBytes(json);
            request.ContentLength = byteArray.Length;

            Stream stream = request.GetRequestStream();
            stream.Write(byteArray, 0, byteArray.Length);
            stream.Close();

            var response = (HttpWebResponse)request.GetResponse();
            if (response.StatusCode == HttpStatusCode.OK)
            {
                Console.Write("PUT => ok \n");
            }
            else
            {
                Console.Write("fail PUT \n");
            }
        }
        
        /** DELETE */
        public static void Delete_API_Java()
        {
            int id = 3;
            WebRequest request = WebRequest.Create("http://localhost:8080/api/JPA/educaciencia/clientes/delete/" + id);
            request.Method = "DELETE";
            var response = (HttpWebResponse)request.GetResponse();

            if (((HttpWebResponse)response).StatusCode == HttpStatusCode.NoContent)
            {
                if (response.StatusCode == HttpStatusCode.NoContent)
                    Console.Write("Delete OK \n");
                else
                    Console.Write("falha Delete \n");
            }
            else
            {
                Console.Write("Falha metodo Delete");
            }

        }


    }
}
