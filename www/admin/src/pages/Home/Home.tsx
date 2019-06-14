import * as React from 'react';
import {Button} from "antd";
import {inject, observer} from "mobx-react";
//
import {BaseProps} from "@/types/props.interface";
import {ReactDPlayer, VJSPlayer} from "@common/components/Player";
import {DraftEditor, QuillEditor} from "@common/components/Editor";

//
export interface HomePageProps extends BaseProps {
}

/**
 * 首页
 */
@inject('store')
@observer
export default class HomePage extends React.Component<HomePageProps> {

    render() {
        return (
            <div>
                <Button>xx1</Button>
                <ReactDPlayer></ReactDPlayer>
                <Button>xx1</Button>
                <VJSPlayer></VJSPlayer>
                <Button>xx1</Button>
                <QuillEditor></QuillEditor>
                <Button>xx1</Button>
                <DraftEditor></DraftEditor>
            </div>
        );
    }

}
