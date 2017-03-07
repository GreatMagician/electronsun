package util.modelUtil;

import model.Effect;
import to.EffectTo;

/**
 * Created by Alexander on 01.03.2017.
 */
public class EffectUtil {
    public static EffectTo createEffectTo(Effect effect){
        return new EffectTo(effect.getId(), effect.getName(), effect.getCountEventEffect(), effect.getTimeStart());
    }
}
