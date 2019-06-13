import {decode} from "jsonwebtoken";
import {Principal} from '@common/types/principal';
import {JwtPayload} from "@common/types/jwt-payload";

/**
 * 解析JWT获取用户信息
 */
export const parseJwtToken = (token: string): Principal | null => {
    if (token) {
        let payload: JwtPayload = decode(token) as JwtPayload;
        if (payload) {
            return payload.principal;
        }
    }
    return null;
};
