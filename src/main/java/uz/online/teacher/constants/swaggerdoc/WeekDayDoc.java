package uz.online.teacher.constants.swaggerdoc;

public class WeekDayDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": {
                      "id": 1,
                      "name": "Dushanba"
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
                    "message": "Region topilmadi: id = 2"
                },
                "data": null
            }
            """;
    public static final String GETALL_RESPONSE_SUCCESS = """
            {
                   "success": true,
                   "message": null,
                   "code": 0,
                   "errors": null,
                   "errorResponse": null,
                   "data": [
                       {
                           "id": 1,
                           "name": "Dushanba"
                       },
                       {
                           "id": 2,
                           "name": "Seshanba"
                       },
                       {
                           "id": 3,
                           "name": "Chorshanba"
                       },
                       {
                           "id": 4,
                           "name": "Payshanba"
                       },
                       {
                           "id": 5,
                           "name": "Juma"
                       },
                       {
                           "id": 6,
                           "name": "Shanba"
                       },
                       {
                           "id": 7,
                           "name": "Yakshanba"
                       }
                   ]
               }
            """;
    public static final String GETALL_RESPONSE_SUCCESS_EMPTY = """
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
