package com.gmail.Xeiotos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 *
 * @author Xeiotos
 */
public class BlockTracker extends BukkitRunnable {

    private final Block block;
    private final Location location;
    private final Byte blockData;
    private final Material material;
    private final FallingBlock physicsBlock;

    public BlockTracker(Block block) {
        this.block = block;
        this.location = block.getLocation();
        this.blockData = block.getData();
        this.material = block.getType();
        block.setType(Material.AIR);
        this.physicsBlock = location.getWorld().spawnFallingBlock(location, material, blockData);
    }

    @Override
    public void run() {
        physicsBlock.setVelocity(new Vector(0, 1, 0));
    }
}