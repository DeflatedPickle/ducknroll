package example

import com.deflatedpickle.ducknroll.common.api.entity.Player
import com.deflatedpickle.ducknroll.common.world.World

fun main() {
    val world = World()

    val player = Player("kevin")
    world.spawn(player)

    world.clock.start()
}