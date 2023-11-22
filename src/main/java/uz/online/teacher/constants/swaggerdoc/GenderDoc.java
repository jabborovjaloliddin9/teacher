package uz.online.teacher.constants.swaggerdoc;

public class GenderDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                 "success": true,
                 "message": null,
                 "code": 0,
                 "errors": null,
                 "errorResponse": null,
                 "data": {
                     "id": 1,
                     "name": "erkak"
                 }
             }
            """;
    public static final String GETONE_RESPONSE_BADREQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 1000,
                    "message": "Gender topilmadi: id = 3"
                },
                "data": null
            }
            """;
    public static final String FINDALL_RESPONSE_SUCCESS = """
            {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": [
                      {
                          "id": 1,
                          "name": "erkak"
                      },
                      {
                          "id": 2,
                          "name": "ayol"
                      }
                  ]
              }
            """;
    public static final String FINDALL_RESPONSE_SUCCESS_EMPTY = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": []
            }
            """;
}
