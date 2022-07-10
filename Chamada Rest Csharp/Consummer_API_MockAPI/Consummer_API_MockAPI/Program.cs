using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net; //importar biblioteca Client
using System.IO;

/******************************************************
 *************** EDUCACIENCIA FAST CODE ***************
 ************ CHAMADA REST - API MOCKAPI **************
 ******************************************************/

namespace Consummer_API_MockAPI
{
    class Program
    {
        /** MAIN */
            static void Main(string[] args)
            {

            /**  Testando Console Basico MockAPI*/
            Console.WriteLine("Testando C# - EducaCiencia FastCode");

            //GetAPI_MockAPI();
            //GetAPI_MockAPI();
            //PostAPI_MockAPI();
            //PutAPI_MockAPI();
            //DeleteAPI_MockAPI();

            Console.ReadKey();

            }

        //Get API MockAPI
        public static void GetAPI_MockAPI()
        {
                string endpointGet = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";
                WebClient api = new WebClient();
                string content = api.DownloadString(endpointGet);
                Console.WriteLine("GetAPI_MOCKAPI");
                Console.WriteLine(content + "\n");
        }

        //Get API  MockAPI
        public static void GetAPI_MockAPI2()
            {
                string endpointGet_2 = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";
                WebRequest request = WebRequest.Create(endpointGet_2);
                request.Method = "GET";
                var response = request.GetResponse();

                if (((HttpWebResponse)response).StatusCode == HttpStatusCode.OK)
                {
                    using (Stream stream = response.GetResponseStream())
                    {
                        StreamReader streamReader = new StreamReader(stream);
                        string content = streamReader.ReadToEnd();
                        Console.WriteLine("GetAPI_Java_2");
                        Console.WriteLine("GET" + content + "\n");
                    }
                }
                else
                {
                    Console.WriteLine("GET Fail \n");
                }
        }

        //Post API MockAPI
        public static void PostAPI_MockAPI()
            {
                string endpointPost = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";
                WebRequest request = WebRequest.Create(endpointPost);
                request.Method = "POST";
                request.ContentType = "application/json; charset=UTF-8";
                string json =
                    "{" +
                    "\"nome\":\"EducacienciaFastCode\"," +
                    "\"email\":\"Educaciencia@FastCode.com.br\"" +
                    "}";

                var byteArray = Encoding.UTF8.GetBytes(json);
                request.ContentLength = byteArray.Length;

                Stream stream = request.GetRequestStream();
                stream.Write(byteArray, 0, byteArray.Length);
                stream.Close();

                var response = (HttpWebResponse)request.GetResponse();
                if (((HttpWebResponse)response).StatusCode == HttpStatusCode.OK)
                {
                    Console.WriteLine("PostAPI_MOCKAPI");
                    Console.WriteLine("Post  => ok");
                    Console.WriteLine(json + "\n");
                }
                else
                {
                    Console.Write("fail Post");
                }
        }

        //Put API MockAPI
        public static void PutAPI_MockAPI()
            {
                string id = "1";
                string endpointPut = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";

                WebRequest request = WebRequest.Create(endpointPut + id);
                request.Method = "PUT";
                request.ContentType = "application/json; charset=UTF-8";
                string json =
                    "{" +
                    "\"id\":\"1\"," +
                    "\"nome\":\"PUT-EducaCiencia\"," +
                    "\"email\":\"PUT-Educaciencia@FastCode.com.br\"" +
                    "}";

                var byteArray = Encoding.UTF8.GetBytes(json);
                request.ContentLength = byteArray.Length;

                Stream stream = request.GetRequestStream();
                stream.Write(byteArray, 0, byteArray.Length);
                stream.Close();

                var response = (HttpWebResponse)request.GetResponse();
                if (((HttpWebResponse)response).StatusCode == HttpStatusCode.OK)
                {
                    Console.WriteLine("PutAPI_MOCKAPI");
                    Console.WriteLine("PUT ID " + id + " => ok ");
                    Console.WriteLine(json + "\n");
                }
                else
                {
                    Console.WriteLine("fail PUT \n");
                }
        }

        //Delete API MockAPI
        public static void DeleteAPI_MockAPI()
            {
                string endpointDelete = "https://600607e63698a80017de12e2.mockapi.io/EducaCiencia";
                string id = "1";
                WebRequest request = WebRequest.Create(endpointDelete + id);
                request.Method = "DELETE";
                var response = (HttpWebResponse)request.GetResponse();

                if (((HttpWebResponse)response).StatusCode == HttpStatusCode.NoContent && (int)response.StatusCode == 204)
                {
                    if ((int)response.StatusCode == 204)
                    Console.WriteLine("DeleteAPI_MOCKAPI");
                    Console.WriteLine("Deletado id " + id + " => OK \n");
                }
                else
                {
                    Console.WriteLine("Falha metodo Delete \n");
                }
        }
       
    
    }
    
}

