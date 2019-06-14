import * as React from 'react';
import DPlayer from 'dplayer'
//
import "./ReactDPlayer.less";

/**
 * 1DPlayer
 *
 * http://dplayer.js.org/
 */
export default class ReactDPlayer extends React.Component<any, any> {
    /**
     * 原生的Video节点
     */
    videoNode: HTMLElement | null = null;
    /**
     * 播放器实例
     */
    player: DPlayer | null = null;

    componentDidMount() {
        this.player = new DPlayer({
            container: this.videoNode
        });
    }

    componentWillUnmount() {
    }

    render() {
        return (
            <div>
                <video ref={node => this.videoNode = node}
                       className="video-js">
                </video>
            </div>
        );
    }
}
