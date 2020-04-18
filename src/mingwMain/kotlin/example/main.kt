package example

import com.deflatedpickle.ducknroll.common.Entity
import com.deflatedpickle.ducknroll.common.world.World

fun main() {
    val world = World()

    val entity = Entity("kevin")

    world.clock.start()
}