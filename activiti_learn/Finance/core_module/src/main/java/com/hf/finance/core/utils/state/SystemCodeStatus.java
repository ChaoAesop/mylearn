package com.hf.finance.core.utils.state;

import org.apache.commons.lang3.SystemUtils;

/**
 * 数据返回状态
 * @since 1.0.0
 */
public class SystemCodeStatus extends SystemUtils {

    // OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
    public static final int SUCCESS = 200;

    public static final int REQUEST_METHOD_ERROR = 302;


    // >=400 用來表示請求出現問題.
    // Input parameter error
    // 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
    public static final int INVALID_ARGUMENT = 400;

    /*201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
    202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
    204 NO CONTENT - [DELETE]：用户删除数据成功。
    401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
    403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
    404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
    406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
    410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
    422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
    500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。*/

    // Forbidden
    public static final int FORBIDDEN = 403;

    // page not found
    public static final int PAGE_NOT_FOUND = 404;

    // Invalid user session (session 失效)
    public static final int INVALID_USER_SESSION = 410;
    // Invalid access token
    public static final int INVALID_ACCESS_TOKEN = 411;

    // internal server error
    public static final int FAILED = 500;

    // >=530 用来表示推送失败
    /**
     * 推送连接失败
     */
    public static final int PUSH_CONNECT_FAILED = 530;
    /**
     * 推送失败
     */
    public static final int PUSH_FAILED = 531;

    // >=540 用來表示验证数据的返回值.
    /**
     * 空值
     */
    public static final int NULL_POINTER = 540;
    /**
     * 数据存在
     */
    public static final int RECORD_EXIST = 541;
    /**
     * 数据为空
     */
    public static final int RECORD_EMPTY = 542;
    /**
     * 数据残缺(不完整)
     */
    public static final int RECORD_IN_COMPLETE = 543;
    /**
     * 数据失效(数据不一致)
     */
    public static final int RECORD_FAILURE = 544;

    /**
     * 类型不匹配
     */
    public static final int RECORD_TYPE_MISMATCH = 546;

    /**
     * 参数为空（验证数据时使用）
     */
    public static final int NULL_PARAMETER = 548;

    /**
     * 查找数据为空
     */
    public static final int NULL_DATA = 549;



    // >=550 用來表示伺服器出現問題.
    /**
     * JSON 数据错误
     */
    public static final int JSON_ERROR = 550;
    /**
     * FILTER 过滤错误
     **/
    public static final int FILTER_ERROR = 551;
    /**
     * CONTROLLER 控制器层错误
     **/
    public static final int CONTROLLER_ERROR = 552;
    /**
     * SERVICE service层错误
     **/
    public static final int SERVICE_ERROR = 553;
    /**
     * DAO dao层错误
     **/
    public static final int DAO_ERROR = 554;
    /**
     * HANDLER  ......错误
     **/
    public static final int HANDLER_ERROR = 555;
    /**
     * FILE_UPLOAD 文件上传错误
     **/
    public static final int FILE_UPLOAD_ERROR = 556;

    /**
     * 角色为空
     */
    public static final int LOGIN_ROLE_EMPTY = 1000;

}
