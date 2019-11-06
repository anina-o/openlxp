import env from "@common/environments/environment";

/**
 * 定义常量
 */
export abstract class Constants {

    /**
     * 版本
     */
    static readonly VERSION : string = '1.0.0';

    /**
     * 服务器
     */
    static readonly SERVER : string = env.server;

}
