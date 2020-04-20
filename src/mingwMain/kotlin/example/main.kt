package example

import com.deflatedpickle.ducknroll.common.api.clock.TickClock
import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.entity.Player
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.world.World
import kotlin.system.getTimeMillis

fun main() {
    val world = World()
    world.clock = TickClock(callback = {
        println(world.timeDate.getTime())

        true
    })
    world.spawn(world.timeDate)

    val player = Player("kevin")
    world.spawn(player)

    world.clock!!.start()
}