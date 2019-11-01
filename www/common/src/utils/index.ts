import {isArray, isEmpty} from 'lodash';

/**
 * 处理后台表单验证错误
 */
export function handleValidationResult(obj : any, result : any) {
    if (!isEmpty(result.data.errors)) {
        let fieldErrors : { [key : string] : any } = {};
        result.data.errors.forEach((e : any) => {
            let messages : any[] = [];
            if (isArray(e.message)) {
                e.message.forEach((message : string) => {
                    messages.push({
                        "message" : message,
                        "field" : e.field
                    });
                });
            } else {
                messages.push({
                    "message" : e.message,
                    "field" : e.field
                });
            }
            fieldErrors[e.field] = {
                value : e.value,
                errors : messages
            }
        });
        console.log(fieldErrors);
        obj.props.form.setFields(fieldErrors);
    }
}
