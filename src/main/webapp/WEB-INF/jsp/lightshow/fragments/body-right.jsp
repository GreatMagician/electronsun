<%@ page import="to.LightShowTo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/fragments/conteiner1.css"/>>
    <script src="/electronsun/resources/js/lightshow/body-right.js" type="text/javascript" charset="utf-8" ></script>

</head>
<div class="show-container1">
    <div class="show-name">
        <label>Название шоу: </label> <label class="value" id="nameShow"></label>
        <label>Прибор: </label> <label class="value" id="nameDevice"></label>
    </div>
    <div class="leds">
        <label class="title">Светодиоды</label> <br/>
        <label class="leds-label">Событие: </label>
        <select onchange="selectEvent()" id="leds-select-event"></select>
        <label style="padding-left: 5px" class="leds-label">Выбрано светодиодов: </label> <label class="leds-value" id="selected-leds">0</label>
        <br/>
        <table>
            <tr>
                <td><label class="leds-label">Цвет: </label></td>
                <td></td>
                <td><input class="leds-input, led-color" type="color" id="leds-color1" value="#fffbfd" onchange="changeColor()"></td>
            </tr>
            <tr>
                <td><label class="leds-label">Появление: </label></td>
                <td></td>
                <td><input class="leds-input" type="number" min="0" value="0" id="leds-number-appearance"/> <label class="leds-label" >мс</label></td>
            </tr>
            <tr>
                <td><label class="leds-label">Длительность свечения: </label></td>
                <td></td>
                <td><input class="leds-input" type="number" min="0" value="1000" id="leds-number-emission"/><label class="leds-label"> мс</label></td>
            </tr>
            <tr>
                <td><label class="leds-label">Яркость: </label></td>
                <td></td>
                <td><input class="leds-input" type="number" min="0" max="100" value="100" id="leds-number-brightness1"/><label class="leds-label"> %</label></td>
            </tr>
            <tr>
                <td><label class="leds-label">Переход в цвет: </label></td>
                <td><input type="checkbox" onchange="checkboxColor()" id="leds-transition"/></td>
                <td><input class="leds-input, led-color" type="color" id="leds-color2" value="#fffbfd"></td>
            </tr>
            <tr>
                <td><label class="leds-label">Длительность перехода: </label></td>
                <td></td>
                <td><input class="leds-input" type="number" min="0" value="1000" id="leds-number-lentransition"/><label class="leds-label"> мс</label></td>
            </tr>
            <tr>
                <td><label class="leds-label">Затухание: </label></td>
                <td></td>
                <td><input class="leds-input" type="number" min="0" value="0" id="leds-number-attenuation"/> <label class="leds-label">мс</label></td>
            </tr>
            <tr>
                <td><label class="leds-label">Длительность паузы: </label></td>
                <td></td>
                <td><input class="leds-input" type="number" min="0" value="0" id="leds-number-pause"/> <label class="leds-label">мс</label></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><input class="leds-input" type="button" onclick="addEvent()" value="Добавить событие" /></td>
                <td><input class="leds-input" type="button" onclick="saveEvent()" value="Сохранить" /></td>
                <td><input class="leds-input" type="button" onclick="deleteEvent()" value="Удалить" /></td>
            </tr>
        </table>
        <div class="effect-name-label">
            <label class="leds-label" >Эффект: </label>
            <label class="ui-widget ui-corner-all ui-state-error" id="nameEffectLabel"
                    title="Перетащите вниз на дорожку, чтобы использовать эффект в шоу"></label>
            <input class="nameEffect-color" type="color" id="nameEffect-color-text" value="#ffffff"
                    onchange="defaultColorNameEffectLabel()" title="Изменить цвет текста эффекта">
            <input class="nameEffect-color" type="color" id="nameEffect-color-background" value="#ffffff"
                   onchange="defaultColorNameEffectLabel()" title="Изменить цвет фона эффекта">
        </div>
        <div class="play-show">
            <label class="play-show-title">Воспроизвести</label> <br/>

            <table class="play-show-table">
                <tr>
                    <td><label class="play-show-label" >Событие</label></td>
                    <td><input type="radio" id="play-radio-event" checked name="play" value="Событие" /></td>
                    <td>
                        <button id="btn-play">
                            <img src=<c:url value="/resources/img/play/play.jpg"/> alt="Воспроизвести">
                        </button>
                    </td>
                </tr>
                <tr>
                    <td><label class="play-show-label">Эффект</label></td>
                    <td><input type="radio" id="play-radio-effect" name="play" value="Эффект" /></td>
                    <td>
                        <button>
                            <img src=<c:url value="/resources/img/play/stop.jpg"/> alt="Остановить">
                        </button>
                    </td>
                </tr>
                <tr>
                    <td><label class="play-show-label">Шоу</label></td>
                    <td><input type="radio" id="play-radio-show" name="play" value="Шоу" /></td>
                </tr>
            </table>
        </div>

        <div class="audio-setting">
            <label class="audio-setting-title">Аудио: </label>
            <label class="value" id="audioname"></label>
            <input class="leds-input" type="button"  value="Загрузить аудио" />
            <input class="leds-input" type="button"  value="Удалить аудио" />
        </div>

        <input type="button" id="saveshow" value="Сохранить световое шоу" />
    </div>


    <div class="effects">
        <label class="title">Эффекты</label> <br/>
        <input type="text" placeholder="Поиск"/>
        <label class="effects-label">Эффекты этого шоу</label>
        <select size="10" id="select-my-effects"> </select>
        <label class="effects-label">Все эффекты</label>
        <select  size="8" id="select-all-effects"> </select>
        <label class="effects-label">Эффекты ремикса</label>
        <select size="3"  id="select-remix-effects"> </select>

        <input type="button" onclick="createEffect()" value="Создать эффект" />

    </div>
</div>
